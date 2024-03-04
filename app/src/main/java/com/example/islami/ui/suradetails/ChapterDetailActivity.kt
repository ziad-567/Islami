package com.example.islami.ui.suradetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.islami.R
import com.example.islami.databinding.ActivityChapterDetailBinding
import kotlin.properties.Delegates

class ChapterDetailActivity : AppCompatActivity() {
    var chapterIndex :Int = 0
    lateinit var chapterTitle:String

    lateinit var viewBinding:ActivityChapterDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChapterDetailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.toolBar)
        chapterIndex =intent.getIntExtra(contects.ChapterIndex,0)
        chapterTitle =intent.getStringExtra(contects.ChapterTitle)?:""
        initViews()
        readSuraFile()
    }

    private fun readSuraFile() {
        val inputStream = assets.open("$chapterIndex.txt")
        val fileContent = inputStream.bufferedReader().use{ it.readText() }
        val lines = fileContent.trim().split("\n")
        initRecycleriew(lines)

    }

    private fun initRecycleriew(verses : List<String>) {
        val adapter = VersesRecyclerAdapter(verses)
        viewBinding.content.recyclerView.adapter = adapter

    }

    private fun initViews() {
        viewBinding.titleTv.text= chapterTitle
        setTitle(null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}