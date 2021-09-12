using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FieldRenovator : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void UpdateField (Map map, List<CellController> cellControllers)
    {
        if (map.Cells.Count != cellControllers.Count)
        {
            Debug.Log("Поменялся размер поля");
        }
        else
        {
            for (int i = 0; i < cellControllers.Count; i++)
            {
                cellControllers[i].SetCell(map.Cells[i].State);
            }
        }
    }
}
