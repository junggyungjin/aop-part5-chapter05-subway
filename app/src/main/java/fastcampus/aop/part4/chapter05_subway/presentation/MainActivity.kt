package fastcampus.aop.part4.chapter05_subway.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fastcampus.aop.part4.chapter05_subway.R
import fastcampus.aop.part4.chapter05_subway.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}