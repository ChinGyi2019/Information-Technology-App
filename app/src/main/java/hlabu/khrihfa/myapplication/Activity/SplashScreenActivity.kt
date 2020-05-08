package hlabu.khrihfa.myapplication.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
//import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.android.synthetic.main.activity_splash_screen.view.*
import hlabu.khrihfa.myapplication.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        setStatusBarTrasparent()
        val imgAnim :Animation = AnimationUtils.loadAnimation(this,R.anim.imag_anim)
        val cpyRAnimation:Animation = AnimationUtils.loadAnimation(this,R.anim.cpy_anim)

        info_tech.startAnimation(imgAnim)
        copyRight.startAnimation(cpyRAnimation)

        val SPLASH_TIME_OUT :Long = 3300
        Handler().postDelayed({
            val intent = Intent(this@SplashScreenActivity, NavigationDrawerActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }

    fun setStatusBarTrasparent(): Unit {
        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        setStatusBarTrasparent()
    }
}
