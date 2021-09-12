using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CellController : MonoBehaviour
{
    [SerializeField]
    GameObject point;
    [SerializeField]
    GameObject wall;
    
    
    public void SetCell (Map.Types.CellState state)
    {
        switch (state)
        {
            case Map.Types.CellState.Point:
                SetPoint();
                break;
            case Map.Types.CellState.Wall:
                SetWall();
                break;
            case Map.Types.CellState.Empty:
                SetEmpty();
                break;
        }
    }
    private void SetPoint ()
    {
        wall.SetActive(false);
        point.SetActive(true);
    }

    private void SetWall ()
    {
        wall.SetActive(true);
        point.SetActive(false);
    }

    private void SetEmpty()
    {
        wall.SetActive(false);
        point.SetActive(false);
    }
}
