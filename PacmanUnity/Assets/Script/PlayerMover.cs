using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using DG.Tweening;

public class PlayerMover : MonoBehaviour
{
    private float rotateTime;
    public Player player;
    private Transform _transform;
    private float gridStep;
    private float speed;

    private void Start()
    {
        _transform = transform;
        BoxCollider2D collider = _transform.GetComponent<BoxCollider2D>();
        gridStep = collider.size.x * _transform.localScale.x;
        speed = gridStep * 1000 / player.MoveTimeMS;
        rotateTime = player.MoveTimeMS / 1000;
        SetPos(player.PosX * gridStep, player.PosY * gridStep);
    }

    private void Update()
    {
        if (_transform.position.y < player.PosY * gridStep)
        {
            SetPos(_transform.position.x, _transform.position.y + speed * Time.deltaTime);
        }
        if (_transform.position.y > player.PosY * gridStep)
        {
            SetPos(_transform.position.x, _transform.position.y - speed * Time.deltaTime);
        }
        if (_transform.position.x < player.PosX * gridStep)
        {
            SetPos(_transform.position.x + speed * Time.deltaTime, _transform.position.y);
        }
        if (_transform.position.x > player.PosX * gridStep)
        {
            SetPos(_transform.position.x - speed * Time.deltaTime, _transform.position.y);
        }
        switch (player.Direction)
        {
            case MoveDirection.Up:
                SetAngle(90);  
                break;
            case MoveDirection.Down:
                SetAngle(270);
                break;
            case MoveDirection.Right:
                SetAngle(0);
                break;
            case MoveDirection.Left:
                SetAngle(180);
                break;
        }
    }

    private void SetPos(float x, float y)
    {
        _transform.position = new Vector3(x, y, 0);
    }

    private void SetAngle (float angle)
    {
        _transform.DORotate(new Vector3(0, 0, angle), rotateTime);
    }
}
