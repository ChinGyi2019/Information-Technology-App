package hlabu.khrihfa.myapplication.Activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hlabu.khrihfa.myapplication.R
import kotlinx.android.synthetic.main.activity_show_subject_detail.*
import kotlinx.android.synthetic.main.activity_show_subject_detail.view.*
import me.myatminsoe.mdetect.MDetect
import me.myatminsoe.mdetect.Rabbit


class ShowSubjectDetailActivity : AppCompatActivity() {
   lateinit var subject_name:String
    lateinit var subject_description:String
    lateinit var subject_code:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_subject_detail)

        setSupportActionBar(show_sub_detail_toolbar)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        show_sub_detail_toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"))

        MDetect.init(this)

        val bundle = intent.extras
        subject_name = bundle.getString("sub_name").toString()
        subject_code= bundle.getString("sub_code").toString()
        subject_description= bundle.getString("description").toString()

        bar_tar_yate.text = "ဘာသာရပ်အမည်"
        bar_tar_code.text = "ဘာသာရပ်ကုဒ်"
        a_chung_a_yar.text ="အကြောင်းအရာ"
       // var zawString = ""
//        if(MDetect.isUnicode()){
//            zawString= Rabbit.(subject_description)
//            description.text = zawString
//
//
//        }else{

            description.text = "   "+subject_description


//        }


        sub_name.text =  subject_name
        sub_code.text = subject_code

     //   myanmar_text.text = bundle.getString("description").toString()
        supportActionBar!!.setTitle(subject_name+" Details")





    }
}
