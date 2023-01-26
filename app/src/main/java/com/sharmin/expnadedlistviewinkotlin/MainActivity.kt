package com.sharmin.expnadedlistviewinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.ImageView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var faqsListView: ExpandableListView
    lateinit var listAdapter: ExpandableFaqsListAdapter

      var faqsListParent: ArrayList<Faq>?= arrayListOf()
     var faqsListChild: ArrayList<Faq>?= arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        faqsListParent?.add(Faq(
            "how are you?"  ,
            "I am fine"
        ))
        faqsListParent?.add(Faq(
            "What are you doing?"  ,
            "I'm studying"
        ))
        faqsListParent?.add(Faq(
            "how are you?2"  ,
            "I am fine2"
        ))

        faqsListChild?.add(Faq(
            "how are you?"  ,
            "I am fine"
        ))
        faqsListChild?.add(Faq(
            "What are you doing?"  ,
            "I'm studying"
        ))
        faqsListChild?.add(Faq(
            "how are you?2"  ,
            "I am fine2"
        ))


        faqsListView = findViewById<ExpandableListView>(R.id.rvFaqs)
        if(faqsListParent!!.isNotEmpty()&& faqsListChild!!.isNotEmpty()){
            listAdapter = ExpandableFaqsListAdapter(this, faqsListParent!!,faqsListChild!!)
            faqsListView.setAdapter(listAdapter)
        }



        faqsListView.setOnGroupClickListener { expandableListView, view, i, l ->
            if (expandableListView.isGroupExpanded(i)) {
                var imgView = view.findViewById<ImageView>(R.id.imgIonNextFaq)
                imgView.setImageDrawable(ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_next_blue))
            } else {
                var imgView = view.findViewById<ImageView>(R.id.imgIonNextFaq)
                imgView.setImageDrawable(ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_up))
            }
            return@setOnGroupClickListener false
        }


      //  return faqsView
    }
}