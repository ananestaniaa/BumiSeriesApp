package com.example.uts

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NovelFragment : Fragment() {

    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: NovelAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_novel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = NovelAdapter(requireContext(), animeList) { item ->
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, item)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}
