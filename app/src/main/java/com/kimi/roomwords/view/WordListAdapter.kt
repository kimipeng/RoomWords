package com.kimi.roomwords.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kimi.roomwords.R
import com.kimi.roomwords.room.Word
import kotlinx.android.synthetic.main.recyclerview_item.view.*

/**
 * Created by Kimi.Peng on 2019-12-31.
 */

class WordListAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<WordListAdapter.WordHolder>() {

    private var words = emptyList<Word>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return WordHolder(view)
    }

    override fun getItemCount(): Int = words.size


    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        val current = words[position]
        holder.wordItemView.text = current.word
    }

    internal fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }


    inner class WordHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wordItemView = itemView.textView
    }


}