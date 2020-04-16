package com.example.labexample

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ImageView
import java.lang.Math.PI
import kotlin.math.atan2

class VolumeControlView(context: Context?, attrs: AttributeSet?) : ImageView(context, attrs) {

    var mx = 0.0f;     var my = 0.0f;     var tx = 0.0f;     var ty = 0.0f;     var angle = 0.0f

    //interface
    var listener:VolumeListener ?= null
    public interface VolumeListener{
        public fun onChanged(angle: Float):Unit
    }


    //listener 설정
    public fun setVolumeListener(listener: VolumeListener) {
        this.listener = listener
    }


    fun getAngle(x1:Float, y1:Float):Float {
        mx = x1-(width /2.0f)
        my = (height/2.0f)-y1
        return (atan2(mx, my) *180.0f/ PI).toFloat()        //위치를 각도로 변환해서 return (-180 ~ +180)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event != null){
            tx = event.getX(0)
            ty = event.getY(0)
            angle = getAngle(tx, ty)
            invalidate()                    //onDraw 다시 호출한것과 동일한 의미
            listener?.onChanged(angle)      //listener가 null이 아니면, 변화된 각도 값을 리스너 호출하여 전달
            return true
        }
        return false
    }

    override fun onDraw(canvas: Canvas?) {
        //canvas가 null이 아니면 화면 회전
        canvas?.rotate(angle, width/2.0f, height/2.0f)
        super.onDraw(canvas)
    }



}