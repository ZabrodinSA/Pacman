using UnityEngine;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace Hotcast.VR.Net
{
    public class SocketClient
    {
        [SerializeField]
        private FieldCreator fieldCreator;
        private static Socket clientSocket;
        public bool IsConnected = false;
        public bool newMessage = false;
        public Message message;

        public SocketClient()
        {
            clientSocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
        }

        public void Connect(string ip, int port)
        {
            IPAddress mIp = IPAddress.Parse(ip);
            IPEndPoint ip_end_point = new IPEndPoint(mIp, port);

            try
            {
                clientSocket.Connect(ip_end_point);
                IsConnected = true;

                Thread threadReceive = new Thread(ReceiveMsg);
                threadReceive.IsBackground = true;
                threadReceive.Start();
                Debug.Log("Есть контакт");
            }
            catch
            {
                IsConnected = false;
                Debug.Log("Сервер не доступен");
                return;
            }
        }

        public void Disconnect()
        {
            if (null != clientSocket && clientSocket.Connected)
            {
                clientSocket.Shutdown(SocketShutdown.Both);
                clientSocket.Close();
            }
        }

        public void Send(Google.Protobuf.IMessage msg)
        {
            if (IsConnected == false)
            {
                Debug.LogError("Нельзя отправлять на не подключенный сервер");
                return;
            }

            if(null == msg)
            {
                Debug.LogError("Нельзя отправлять пустые сообщения！");
                return;
            }
            
            try
            {
                clientSocket.Send(ProtobufEncoding.Encode(msg));
            }
            catch
            {
                IsConnected = false;
                clientSocket.Shutdown(SocketShutdown.Both);
                clientSocket.Close();
            }
        }

        private void ReceiveMsg()
        {
            byte[] buffer = new byte[4096];
            int len = 0;
            while (true)
            {
                len = clientSocket.Receive(buffer);
                if(len <= 0)
                {
                    continue;
                }
                message = ProtobufEncoding.Decode(buffer) as Message;
                //Debug.Log(message);
                newMessage = true;
            }
        }
    }
}