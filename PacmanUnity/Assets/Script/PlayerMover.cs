using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using DG.Tweening;

public class PlayerMover : MonoBehaviour
{
    [SerializeField]
    private float moveTime;
    [SerializeField]
    private float rotateTime;
    public Player player;
    private Transform _transform;
    private float gridStep;
    private int oldX;
    private int oldY;

    private void Start()
    {
        _transform = transform;
        BoxCollider2D collider = _transform.GetComponent<BoxCollider2D>();
        gridStep = collider.size.x * _transform.localScale.x;
        oldX = player.PosX;
        oldY = player.PosY;
    }

    public void movePlayer()
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
    }

    private void move()
    {
        var seq = DOTween.Sequence();
        seq.Append(_transform.DOMove(new Vector3(player.PosX * gridStep, player.PosY * gridStep, 0), player.MoveTimeMS / 1000));//.SetEase<Sequence>(Ease.Linear);
        oldX = player.PosX;
        oldY = player.PosY;

    }
}
