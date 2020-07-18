package com.mibanyarchan.footballteam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mibanyarchan.footballteam.R
import com.mibanyarchan.footballteam.model.TeamItem

class TeamDetails(
 private val teamList:ArrayList<TeamItem>,
         val context:Context
):RecyclerView.Adapter<TeamDetails.TeamViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.teamview_list,parent,false)
        return TeamViewHolder(itemView)
    }

    override fun getItemCount()=teamList.size


    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val currentItem=teamList[position]
        Glide.with(context).load(teamList.get(position).strTeamLogo).into(holder.img_TeamLogo)
        holder.txt_TeamName.text=teamList.get(position).strTeam

    }
    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_TeamLogo:ImageView=itemView.findViewById(R.id.img_TeamLogo)
        val txt_TeamName:TextView=itemView.findViewById(R.id.txt_teamName)

    }

}