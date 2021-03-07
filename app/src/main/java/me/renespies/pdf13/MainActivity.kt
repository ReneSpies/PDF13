package me.renespies.pdf13

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import me.renespies.pdf13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        val intent = intent

        intent.data?.let { pdfUri ->

            binding.pdfView.apply {

                fromUri(pdfUri).apply {

                    defaultPage(0)
                    enableDoubletap(true)
                    enableAnnotationRendering(true)
                    enableAntialiasing(true)
                    enableSwipe(true)
                    spacing(5)
                    swipeHorizontal(true)
                    load()

                }

                doRenderDuringScale()
                useBestQuality(true)

            }

        }

        setContentView(binding.root)

    }

}