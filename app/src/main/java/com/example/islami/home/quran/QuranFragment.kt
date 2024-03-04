package com.example.islami.home.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.ui.suradetails.ChapterDetailActivity
import com.example.islami.ui.suradetails.contects
import kotlinx.coroutines.channels.ticker

class QuranFragment:Fragment() {

    lateinit var viewbBinding:FragmentQuranBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewbBinding = FragmentQuranBinding.inflate(inflater,container,false)
        return viewbBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initChapterRecycler()
    }
    private val chapters = listOf("الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام",
        "الأعراف","الأنفال","التوبة","يونس","هود","يوسف","الرعد","إبراهيم","الحجر","النحل",
        "الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون","النّور","الفرقان","الشعراء",
        "النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ","فاطر","يس",
        "الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف",
        "محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة",
        "الحديد","المجادلة","الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق",
        "التحريم","الملك","القلم","الحاقة","المعارج","نوح","الجن","المزّمّل","المدّثر","القيامة",
        "الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار","المطفّفين", "الإنشقاق",
        "البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس"
        ,"الليل","الضحى","الشرح"
        ,"التين","العلق","القدر","البينة","الزلزلة","العاديات"
        ,"القارعة","التكاثر","العصر",
        "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون",
        "النصر","المسد","الإخلاص","الفلق","الناس")
    lateinit var adapter :ChapterRecyclerAdapter
    private fun initChapterRecycler() {
        adapter = ChapterRecyclerAdapter(chapters)
        adapter.onItemClickListener =
            ChapterRecyclerAdapter.OnItemClickListener { item, position ->
            startSuraDetailsActivity(item,position)
        }
        viewbBinding.chapterRecycler.adapter=adapter
    }

    private fun startSuraDetailsActivity(title: String, position: Int) {
        val intent = Intent(activity,ChapterDetailActivity::class.java)
        intent.putExtra(contects.ChapterIndex,position+1)
        intent.putExtra (contects.ChapterTitle , title)
        startActivity(intent)

    }


}