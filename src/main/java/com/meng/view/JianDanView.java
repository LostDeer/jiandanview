package com.meng.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by LiChaoBo on 2017/9/14.
 */

public class JianDanView extends View {

    private Paint mYellowPaint;
    private Paint mRedPaint;
    private int mWindowWidth;
    private int mTopHeight;
    private int mBottomHeight;
    private int mCenWindth;
    private int mTop =200;
    private int mRect=30;
    private int mOneStart;
    private int mOneEnd;
    private int mTwoStart;
    private int mTwoEnd;
    private Paint mOrangePaint;
    private Paint mBlackPaint;

    public JianDanView(Context context) {
        this(context,null);
    }

    public JianDanView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public JianDanView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();

    }
    // 创建画笔
    private void initPaint() {
        mYellowPaint = new Paint();
        mYellowPaint.setAntiAlias(true);
        mYellowPaint.setDither(true);
        mYellowPaint.setColor(Color.parseColor("#FFFF00"));

        mRedPaint = new Paint();
        mRedPaint.setAntiAlias(true);
        mRedPaint.setColor(Color.RED);
        mRedPaint.setDither(true);

        mOrangePaint = new Paint();
        mOrangePaint.setAntiAlias(true);
        mOrangePaint.setColor(Color.parseColor("#FFC000"));
        mOrangePaint.setDither(true);

        mBlackPaint = new Paint();
        mBlackPaint.setAntiAlias(true);
        mBlackPaint.setColor(Color.BLACK);
        mBlackPaint.setDither(true);

        WindowManager systemService = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = systemService.getDefaultDisplay();
        mWindowWidth = display.getWidth();

        mCenWindth = mWindowWidth / 2-mRect;

        mOneStart =mWindowWidth/9*3 ;//第一行
        mOneEnd = mWindowWidth/9*3+mOneStart;

    }

    /**
     * 矩形的高 height = bottom  - mTop
       矩形的宽 width  = right – left
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(mCenWindth, mTop, mCenWindth+mRect, mTop+mRect,mRedPaint);
        canvas.drawRect(mCenWindth, mTop+mRect, mCenWindth+mRect*2, mTop+mRect*2,mRedPaint);
//        canvas.drawRect(mCenWindth+mRect, mTop+mRect, mCenWindth+mRect*2, mTop+mRect*2,mRedPaint);

        canvas.drawRect(mOneStart,mTop+mRect*2,mOneEnd,mTop+mRect*3,mYellowPaint);
        
        for (int i = 0; i <= 19; i++) {
            mTopHeight =mTop+mRect*(2+i);
            mBottomHeight=mTop+mRect*(3+i);
            if(i<2 ||i==17){
                if(i<2){
                    mTwoStart = mWindowWidth / 7 * (3-i);
                    mTwoEnd = mWindowWidth / 7 * (4+i);
                }
                canvas.drawRect(mTwoStart, mTopHeight,mTwoEnd,mBottomHeight, i==17?mOrangePaint:mYellowPaint);
            }else if(i==2||i==16){
                canvas.drawRect(mTwoStart-mRect, mTopHeight,mTwoEnd+mRect,mBottomHeight,
                        mYellowPaint);
                if(i==16){
                    canvas.drawRect(mTwoEnd, mTopHeight,mTwoEnd+mRect,mBottomHeight,
                            mOrangePaint);

                    canvas.drawRect(mTwoStart-mRect, mTopHeight,mTwoStart,mBottomHeight,
                            mOrangePaint);
                }
            }else if(i>2&&i<5||i==15){
                canvas.drawRect(mTwoStart-mRect*2, mTopHeight,mTwoEnd+mRect*2,mBottomHeight,
                        mYellowPaint);
                if(i==15){
                    canvas.drawRect(mTwoStart-mRect*2, mTopHeight,mTwoStart-mRect*1,
                            mBottomHeight, mOrangePaint);

                    canvas.drawRect(mTwoEnd+mRect*1, mTopHeight,mTwoEnd+mRect*2,mTop+mRect*
                            (3+i), mOrangePaint);
                }
            }else if(i==5||i==6 ||i==13 ||i==14){
                canvas.drawRect(mTwoStart-mRect*3, mTopHeight,mTwoEnd+mRect*3,mBottomHeight,
                        mYellowPaint);
                if(i==5){
                    //左眼睛
                    canvas.drawRect(mTwoStart+mRect*2, mTopHeight,mTwoStart+mRect*3,
                            mTop+mRect* (3+i), mBlackPaint);
                    //右眼睛
                    canvas.drawRect((float) (mTwoStart+mRect*7.5), mTopHeight,
                            (float) (mTwoStart+mRect*8.5),
                            mTop+mRect* (3+i), mBlackPaint);
                }
                //左耳朵
                canvas.drawRect(mTwoStart-mRect*3, mTopHeight,mTwoStart-mRect*2,mTop+mRect* (3+i), mOrangePaint);
                //右耳朵
                canvas.drawRect(mTwoEnd+mRect*2, mTopHeight,mTwoEnd+mRect*3,mTop+mRect* (3+i), mOrangePaint);
            }else if(i==7|| i==12){
                canvas.drawRect(mTwoStart-mRect*4, mTopHeight,mTwoEnd+mRect*4,mBottomHeight,
                        mYellowPaint);
                //鼻子嘴巴
                if(i==7){
                    canvas.drawRect(mCenWindth, mTopHeight, mCenWindth+mRect*2, mTop+mRect* (3+i),mOrangePaint);
                }else if(i==12){
                    //左
                    canvas.drawRect(mTwoStart-mRect*4, mTopHeight,mTwoStart-mRect*2, mBottomHeight,
                            mOrangePaint);
                    //右
                    canvas.drawRect(mTwoEnd+mRect*2, mTopHeight,mTwoEnd+mRect*4,mTop+mRect*
                            (3+i),
                            mOrangePaint);
                }
            }else if(i==8 ){
                canvas.drawRect(mTwoStart-mRect*5, mTopHeight,mTwoEnd+mRect*5,mBottomHeight,
                        mYellowPaint);
                //鼻子嘴巴
                canvas.drawRect(mCenWindth, mTopHeight, mCenWindth+mRect*2, mTop+mRect* (3+i),mOrangePaint);
            }else if(i>8&&i<=11){
                canvas.drawRect(mTwoStart-mRect*6, mTopHeight,mTwoEnd+mRect*6,mBottomHeight,
                        mYellowPaint);
                if(i==11){
                    //左
                    canvas.drawRect(mTwoStart-mRect*3, mTopHeight,mTwoStart-mRect*2,mBottomHeight,
                            mOrangePaint);
                    //右
                    canvas.drawRect(mTwoEnd+mRect*2, mTopHeight,mTwoEnd+mRect*3,mTop+mRect* (3+i), mOrangePaint);
                }
            }else if(i==18){
                //左右脚
                canvas.drawRect(mTwoStart+mRect*2, mTopHeight,mTwoStart+mRect*3,mTop+mRect*
                        (3+i), mBlackPaint);

                canvas.drawRect(mTwoEnd-mRect*3, mTopHeight,mTwoEnd-mRect*2,mTop+mRect*
                        (3+i), mBlackPaint);
            }else if(i==19){
                //左右脚
                canvas.drawRect(mTwoStart+mRect*1, mTopHeight,mTwoStart+mRect*4,mTop+mRect*
                        (3+i), mBlackPaint);

                canvas.drawRect(mTwoEnd-mRect*4, mTopHeight,mTwoEnd-mRect*1,mTop+mRect*
                        (3+i), mBlackPaint);
            }
        }
    }
}
