package si.kflabs.mojpanj.ui

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import si.kflabs.mojpanj.R
import android.content.Intent
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash.*
import si.kflabs.mojpanj.ui.home.MainActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(Runnable { /* Create an Intent that will start the Menu-Activity. */

        }, 3000)

        animationView.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
                this@SplashActivity.startActivity(mainIntent)
                this@SplashActivity.finish()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationRepeat(animation: Animator?) {
            }

        })
    }
}