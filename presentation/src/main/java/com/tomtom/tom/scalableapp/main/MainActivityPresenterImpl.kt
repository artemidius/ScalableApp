package com.tomtom.tom.scalableapp.main

import android.util.Log
import com.tomtom.tom.scalableapp.base.BaseActivity

class MainActivityPresenterImpl(mainActivity: BaseActivity):MainActivityContract.Presenter {

    val tag = this.javaClass.simpleName

    override fun onCreate()   {  Log.d(tag, "Activity triggered onCreate()")    }
    override fun onResume()   {  Log.d(tag, "Activity triggered onResume()")    }
    override fun onPause()    {  Log.d(tag, "Activity triggered onPause()")     }
    override fun onDestroy()  {  Log.d(tag, "Activity triggered onDestroy()")   }
    override fun onStop()     {  Log.d(tag, "Activity triggered onStop()")      }

}