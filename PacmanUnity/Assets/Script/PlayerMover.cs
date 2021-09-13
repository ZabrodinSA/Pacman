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
        SetPos();
    }

    private void Update()
    {
        switch (player.Direction)
        {
            case MoveDirection.Up:
                if (_transform.position.y < player.PosY * gridStep)
                {
                    _transform.position = new Vector3(_transform.position.x, _transform.position.y + speed * Time.deltaTime, 0);
                    _transform.DORotate(new Vector3(0, 0, 90), rotateTime);
                }
                else SetPos();
                break;
            case MoveDirection.Down:
                if (_transform.position.y > player.PosY * gridStep)
                {
                    _transform.position = new Vector3(_transform.position.x, _transform.position.y - speed * Time.deltaTime, 0);
                    _transform.DORotate(new Vector3(0, 0, 270), rotateTime);
                }
                else SetPos();
                break;
            case MoveDirection.Right:
                if (_transform.position.x < player.PosX * gridStep)
                {
                    _transform.position = new Vector3(_transform.position.x + speed * Time.deltaTime, _transform.position.y, 0);
                    _transform.DORotate(new Vector3(0, 0, 0), rotateTime);
                }
                else SetPos();
                break;
            case MoveDirection.Left:
                if (_transform.position.x > player.PosX * gridStep)
                {
                    _transform.position = new Vector3(_transform.position.x - speed * Time.deltaTime, _transform.position.y, 0);
                    _transform.DORotate(new Vector3(0, 0, 180), rotateTime);
                }
                else SetPos();
                break;
            case MoveDirection.Non:
                SetPos();
                break;
        }
    }

    public void SetPos()
    {
        _transform.position = new Vector3(player.PosX * gridStep, player.PosY * gridStep, 0);
    }

}
