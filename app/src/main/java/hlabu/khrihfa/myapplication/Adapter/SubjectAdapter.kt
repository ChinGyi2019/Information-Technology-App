package hlabu.khrihfa.myapplication.Adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.util.Log
import android.view.LayoutInflater
import android.view.LayoutInflater.*
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hlabu.khrihfa.myapplication.Activity.ShowSubjectDetailActivity
import hlabu.khrihfa.myapplication.Adapter.inflate
import hlabu.khrihfa.myapplication.model.Subject
import hlabu.khrihfa.myapplication.R
import kotlinx.android.synthetic.main.sub_detail_layout.*
import kotlinx.android.synthetic.main.sub_detail_layout.view.*

lateinit var subject:ArrayList<Subject>
lateinit var mContext: Context


class SubjectAdapter(private val subjectList:ArrayList<Subject>)
    :RecyclerView.Adapter<SubjectHolder>() {
    override fun onBindViewHolder(holder: SubjectHolder, position: Int) {
        val subject = subjectList.get(position)
        holder.bindView(subject)

    }

    //override fun onBindViewHolder(holder: ViewHolder, position: Int) {






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectHolder {
        val inflatedView = parent.inflate(R.layout.sub_detail_layout, false)
        return SubjectHolder(inflatedView)

      }

    override fun getItemCount() = subjectList.size
}

class SubjectHolder(v:View):RecyclerView.ViewHolder(v),View.OnClickListener {
    private var view: View = v
    private var subject: Subject ? = null

    init {
    v.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.d("RecyclerView", "CLICK!")

        val context = itemView.context
        val bundle:Bundle = Bundle()

            val intent :Intent = Intent(context,ShowSubjectDetailActivity::class.java)
            bundle.putString("sub_name",subject!!.sub_name)
            bundle.putString("sub_code",subject!!.sub_code)
            bundle.putString("description",subject!!.description)
            //bundle.putString("sub_name",subject!!.sub_name)
            intent.putExtras(bundle)
            startActivity(context,intent,bundle)

            Toast.makeText(context,subject!!.sub_name.toString(),Toast.LENGTH_SHORT).show()





       // var intent: Intent = Intent(ge,ShowSubjectDetailActivity::javaClass)

    }
    companion object {
        //5
        private val Subject_Key = "Subject"
    }

      fun bindView(subject:Subject){
        this.subject = subject
        view.sub_name.text = subject.sub_name
        view.sub_code.text = subject.sub_code

    }
}