using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;

public class FieldCreator : MonoBehaviour
{
    [SerializeField]
    private GameObject cellPrefab;
    [SerializeField]
    private GameObject playerPrefab;
    private float gridStep;

    public List<CellController> CreateCells (Map map)
    {
        List<CellController> result = new List<CellController>(map.Cells.Count);
        BoxCollider2D cellCollider = cellPrefab.GetComponent<BoxCollider2D>();
        gridStep = cellCollider.size.x * cellPrefab.transform.localScale.x;
        for (int i = 0; i < map.Cells.Count; i++)
        {
            GameObject obj = Instantiate(cellPrefab, transform);
            obj.name = "cell" + i;
            CellController cellController = obj.GetComponent<CellController>();
            obj.transform.position = new Vector2(map.Cells[i].X * gridStep, map.Cells[i].Y * gridStep);
            cellController.SetCell(map.Cells[i].State);
            result.Add(cellController);
        }
        return result;
    }

    public List<GameObject> CreatePlayers (Players players)
    {
        List<GameObject> result = new List<GameObject>(players.Players_.Count);

        for (int i = 0; i < players.Players_.Count; i++)
        {
            result.Add(CreatePlayer(players.Players_[i]));            
        }
        return result;
    }

    public GameObject CreatePlayer (Player player)
    {
        GameObject obj = Instantiate(playerPrefab);
        PlayerMover playerMover = obj.GetComponent<PlayerMover>();
        playerMover.player = player;
        obj.name = "player" + player.ID;
        obj.transform.position = new Vector2(player.PosX * gridStep, player.PosY * gridStep);
        return obj;
    }

}
