package com.example.tms_an_15_homework_lesson_19.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_an_15_homework_lesson_19.ItemNote
import com.example.tms_an_15_homework_lesson_19.R

class NoteViewAdapter : RecyclerView.Adapter<NoteViewAdapter.NoteViewHolder>() {
    private val noteList = mutableListOf<ItemNote>()

    fun addNoteList(note: ItemNote) {
        noteList.add(note)
        notifyItemInserted(noteList.lastIndex)
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val text: TextView = itemView.findViewById(R.id.text)
        val date: TextView = itemView.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_note_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = noteList[position]
        holder.title.text = note.title
        holder.text.text = note.text
        holder.date.text = note.date
    }
}