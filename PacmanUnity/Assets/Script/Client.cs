using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Hotcast.VR.Net;


public class Client : MonoBehaviour
{
    [SerializeField]
    private FieldCreator fieldCreator;
    [SerializeField]
    private FieldRenovator fieldRenovator;
    private List<GameObject> playersObj;
    private List<CellController> cellControllers;

    private string IP = "127.0.0.1";
    private string ID;
    private int port = 8080;
    private SocketClient client;
    private MoveCommands oldCommands;
    private MoveCommands newCommands;

    void Start()
    {
        client = new SocketClient();
        client.Connect(IP, port);
        while (true)
        {
            if (client.newMessage)
            {
                cellControllers = fieldCreator.CreateCells(client.message.Map);
                playersObj = fieldCreator.CreatePlayers(client.message.Players);
                ID = playersObj[playersObj.Count - 1].GetComponent<PlayerMover>().player.ID;
                client.newMessage = false;
                break;
            }
        }
        oldCommands = SetCommands();
        client.Send(oldCommands);

    }

    void Update()
    {
        if (client.newMessage)
        {
            //Обновляем поле
            fieldRenovator.UpdateField(client.message.Map, cellControllers);
            //Двигаем всех игроков что прислал сервер, если не находим по ID, то создаём
            for (int i = 0; i < client.message.Players.Players_.Count; i++)
            {
                Player player = client.message.Players.Players_[i];
                GameObject playerObj = playersObj.Find(x => x.GetComponent<PlayerMover>().player.ID == player.ID);
                if (playerObj == null)
                {
                    playersObj.Add(fieldCreator.CreatePlayer(client.message.Players.Players_[i]));
                }
                else
                {
                    playerObj.GetComponent<PlayerMover>().player = player;
                   // playerObj.GetComponent<PlayerMover>().movePlayer();
                }
            }
            //Убираем отключившихся
            for (int i = 0; i < playersObj.Count; i++)
            {
                bool flag = false;
                for (int j = 0; j < client.message.Players.Players_.Count; j++)
                {
                    if (playersObj[i].GetComponent<PlayerMover>().player.ID == client.message.Players.Players_[j].ID)
                    {
                        flag = true;
                    }
                }
                if (!flag)
                {
                    GameObject player = playersObj[i];
                    playersObj.RemoveAt(i);
                    Destroy(player);
                }
            }
            client.newMessage = false;
        }
        newCommands = SetCommands();
        if (!oldCommands.Equals(newCommands))
        {
            client.Send(newCommands);
            oldCommands = newCommands;
        }
    }

    private MoveCommands SetCommands ()
    {
        MoveCommands moveCommands = new MoveCommands();
        moveCommands.ID = ID;
        if (Input.GetKey(KeyCode.UpArrow))
        {
            moveCommands.Directions.Add(MoveDirection.Up);
        }
        if (Input.GetKey(KeyCode.DownArrow))
        {
            moveCommands.Directions.Add(MoveDirection.Down);
        }
        if (Input.GetKey(KeyCode.RightArrow))
        {
            moveCommands.Directions.Add(MoveDirection.Right);
        }
        if (Input.GetKey(KeyCode.LeftArrow))
        {
            moveCommands.Directions.Add(MoveDirection.Left);
        }
        return moveCommands;
    }
    void OnApplicationQuit()
    {
        if (null != client)
        {
            client.Disconnect();
        }
    }
}
