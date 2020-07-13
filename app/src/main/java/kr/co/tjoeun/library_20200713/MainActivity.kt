package kr.co.tjoeun.library_20200713

import android.content.Intent
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

        goToPhotoView.setOnClickListener {
            val myIntent = Intent(mContext, ProfilePhotoActivity::class.java)
            startActivity(myIntent)
        }

    }

    override fun setValues() {

        val imgUrl = "https://t1.daumcdn.net/cfile/tistory/99AADE425EA423D021"
        Glide.with(mContext).load(imgUrl).into(profileImg)

    }


}