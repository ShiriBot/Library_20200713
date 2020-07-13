package kr.co.tjoeun.library_20200713

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_photo.*
import java.security.Permission

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()

        setValues()

    }

    override fun setupEvents() {

        callBtn.setOnClickListener {



            val permissionListener = object : PermissionListener{
                override fun onPermissionGranted() {
//                    승인을 받은 상황.=> 실제로 전화를 걸자
                    val phoneNum = phoneNumTxt.text.toString()

                    val myUri = Uri.parse("tel:${phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL,myUri)
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                    최종 거부된 상황. 통화를 할 수 없다.

                    Toast.makeText(mContext,"통화권한이 거부되어 연결이 불가합니다.",Toast.LENGTH_SHORT).show()
                }
            }

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