package kr.co.tjoeun.library_20200713

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_photo.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()

        setValues()

    }

    override fun setupEvents() {

        callBtn.setOnClickListener {

            val phoneNum = phoneNumTxt.text.toString()

            val myUri = Uri.parse("tel:${phoneNum}")

            val myIntent = Intent(Intent.ACTION_CALL,myUri)
            startActivity(myIntent)


        }

        goToPhotoView.setOnClickListener {
            val myIntent = Intent(mContext, ProfilePhotoActivity::class.java)
            startActivity(myIntent)
        }

    }

    override fun setValues() {

        val imgUrl = "https://photo.jtbc.joins.com/news/2016/07/20/20160720150515543.jpg"
        Glide.with(mContext).load(imgUrl).into(profileImg)

    }


}