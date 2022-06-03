package com.example.lib

class ClickListenerTest {

    fun testRunnable() {
        setRunnable {

        }
    }

    fun setRunnable(runnable: Runnable) {
        runnable.run()
    }

    fun testCallBack() {
        setCallBack(object : CallBack {
            override fun back() {

            }
        })

//        setCallBack {
//        }
    }

    fun setCallBack(callBack: CallBack) {
        callBack.back()
    }

    fun test() {
        setClickListener(object : ClickListener {

            override fun onClick() {

            }

            override fun onLongClick() {

            }
        })
    }

    fun setClickListener(listener: ClickListener) {
        listener.onClick()
        listener.onLongClick()
    }
}