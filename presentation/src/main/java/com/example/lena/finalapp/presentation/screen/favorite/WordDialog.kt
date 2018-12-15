package com.example.lena.finalapp.presentation.screen.favorite

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatDialogFragment
import android.content.DialogInterface
import android.content.Intent
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AlertDialog
import android.util.Log
import com.example.domain.entity.Word
import com.example.lena.finalapp.R
import com.gmail.superarch.app.App


class WordDialog : AppCompatDialogFragment() {

//    val word: Word
//
//    constructor(word: Word){
//
//    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(App.instance.baseContext)
        builder.setMessage(R.string.dialog_word)
                .setPositiveButton(R.string.remove
                ) { dialog, id ->
                    fun onClick(dialog: DialogInterface, id: Int) {
                        Log.e("aaa","click remove word")

//                        sendMessage("CLICK_REMOVE")
                    }
                }
                .setNegativeButton(R.string.remove
                ) { dialog, id ->
                    fun onClick(dialog: DialogInterface, id: Int) {
                        Log.e("aaa","click save word")
//                        sendMessage("CLICK_SAVE")
                    }
                }

        return builder.create()
    }

    private fun sendMessage(action: String) {
//        Log.d("aaa", "Broadcasting: $action")
//        val intent = Intent(action)
//        intent.putExtra("message", wordRU.get())
//        LocalBroadcastManager.getInstance(App.instance.baseContext).sendBroadcast(intent)
    }
}