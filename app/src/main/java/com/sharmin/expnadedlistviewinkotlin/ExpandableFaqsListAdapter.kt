package com.sharmin.expnadedlistviewinkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class ExpandableFaqsListAdapter (val _context: Context,
                                 val _listDataHeader: ArrayList<Faq>,
                                 private val _listChild: List<Faq> // header titles
) : BaseExpandableListAdapter() {


    var _listDataHeaderFiltered: ArrayList<Faq>
    var _listDataHeaderOriginal = ArrayList<Faq>()

    init {
        _listDataHeaderFiltered = _listDataHeader
        _listDataHeaderOriginal.addAll(_listDataHeader)
    }

    override fun getChild(groupPosition: Int, childPosititon: Int): Any {
        return _listDataHeaderFiltered[groupPosition].answer
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int,
                              isLastChild: Boolean, convertView: View?, parent: ViewGroup
    ): View {
        var convertView = convertView

        val childText = getChild(groupPosition, childPosition) as String

        if (convertView == null) {
            val infalInflater = this._context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.item_child, null)
        }

        convertView!!.findViewById<TextView>(R.id.txtFaqAnswer).text=childText

       // convertView!!.txtFaqAnswer.text = childText
        /*val txtListChild = convertView!!
                .findViewById(R.id.lblListItem) as TextView
        txtListChild.text = childText
        */
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return 1
    }

    override fun getGroup(groupPosition: Int): Any {
        return this._listDataHeaderFiltered[groupPosition].question
    }

    override fun getGroupCount(): Int {
        return this._listDataHeaderFiltered.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean,
                              convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val headerTitle = getGroup(groupPosition) as String
        if (convertView == null) {
            val infalInflater = this._context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.item_faqs_parent, null)
        }

        if (groupPosition % 2 == 1) {
            convertView?.setBackgroundResource(R.color.purple_200)
        } else {
            convertView?.setBackgroundResource(R.color.teal_200)
        }
        convertView!!.findViewById<TextView>(R.id.txtFaqs).text=headerTitle
       // convertView!!.txtFaqs.text = headerTitle

        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}
