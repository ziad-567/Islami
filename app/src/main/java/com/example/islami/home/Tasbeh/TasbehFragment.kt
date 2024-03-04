package com.example.islami.home.Tasbeh

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentTasbehBinding

class TasbehFragment:Fragment(){

    lateinit var viewBinding :FragmentTasbehBinding
    var count = 1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTasbehBinding.inflate(inflater,container,false)
        sebhafun()
        return viewBinding.root
    }


    private fun RotateSebha() {
        viewBinding.bodySebhaLogo.animate().rotationBy(45f).setDuration(500).start()

    }

    private fun sebhafun() {

        var sebhakind = arrayOf( "سُبْحَانَ اللَّهِ", "الْحَمْدُ لِلَّهِ" ,"اللَّهُ أَكْبَر")
        var index = 0
        viewBinding.buttonCount.setOnClickListener {
            count++
            RotateSebha()
            if (count <= 33)
            viewBinding.textCounter.text=count.toString()
            else {
                count = 0
                index = (index + 1) % sebhakind.size
                viewBinding.buttonCount.text = sebhakind[index]

            }
        }

    }


}
