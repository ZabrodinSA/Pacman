using Google.Protobuf;
using System;
using System.IO;
using UnityEngine;

public class ProtobufEncoding
{
    public static byte[] Encode(IMessage msg)
    {
        using (MemoryStream rawOutput = new MemoryStream())
        {
            CodedOutputStream output = new CodedOutputStream(rawOutput);
            output.WriteMessage(msg);
            output.Flush();
            byte[] result = rawOutput.ToArray();
            
            return result;
        }
    }

    public static IMessage Decode(byte[] msg)
    {
        IMessage message = null;
        CodedInputStream stream = new CodedInputStream(msg);
            try
            {
                byte[] body = stream.ReadBytes().ToByteArray();
                message = Message.Parser.ParseFrom(body);
            }
            catch (Exception exception)
            {
                Debug.Log(exception.Message);
            }
      
        return message;
    }

}