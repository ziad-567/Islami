
package com.example.islami.ui.hadethdetails

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islami.R
import com.example.islami.databinding.ActivityHadethDetailsBinding
import com.example.islami.databinding.ItemHadethTitleBinding
import com.example.islami.home.model.Hadeth
import com.example.islami.ui.suradetails.contects

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        extractParams()
        initViews()
    }

    private fun initViews() {
        setTitle(null)//jk
        setSupportActionBar(viewBinding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        viewBinding.titleTv.text = hadeth?.title
        viewBinding.content.content.text = hadeth?.content

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    var hadeth: Hadeth? = null
    private fun extractParams() {
         hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(contects.Hadeth_EXTRA,Hadeth::class.java)
        } else {
              intent.getParcelableExtra<Hadeth>(contects.Hadeth_EXTRA)
        }

    }
}