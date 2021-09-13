using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using DG.Tweening;

public class PlayerMover : MonoBehaviour
{
    //[SerializeField]
    //private float moveTime;
    //[SerializeField]
    private float rotateTime;
    public Player player;
    private Transform _transform;
    private float gridStep;
    private float speed;
    //private int oldX;
    //private int oldY;

    private void Start()
    {
        _transform = transform;
        BoxCollider2D collider = _transform.GetComponent<BoxCollider2D>();
        gridStep = collider.size.x * _transform.localScale.x;
        //oldX = player.PosX;
        //oldY = player.PosY;
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
                    Debug.Log("left");
                    _transform.DORotate(new Vector3(0, 0, 180), rotateTime); 
                }
                else SetPos();
                break;
            case MoveDirection.Non:
                SetPos();
                break;
        }
    }

    /*    public void movePlayer()
        {
            if (player.PosX > oldX)
            {
                _transform.DORotate(new Vector3(0, 0, 0), rotateTime);
                move();
            }
            else if (player.PosX < oldX)
            {
                _transform.DORotate(new Vector3(0, 0, 180), rotateTime);
                move();
            }
            else if (player.PosY > oldY)
            {
                _transform.DORotate(new Vector3(0, 0, 90), rotateTime);
                move();
            }
            else if (player.PosY < oldY)
            {
                _transform.DORotate(new Vector3(0, 0, 270), rotateTime);
                move();
            }
        }*/

    /*    private void move()
        {
            var seq = DOTween.Sequence();
            seq.Append(_transform.DOMove(new Vector3(player.PosX * gridStep, player.PosY * gridStep, 0), player.MoveTimeMS / 1000));//.SetEase<Sequence>(Ease.Linear);
            oldX = player.PosX;
            oldY = player.PosY;

        }*/

    private void SetPos()
    {
        _transform.position = new Vector3(player.PosX * gridStep, player.PosY * gridStep, 0);
    }

}
