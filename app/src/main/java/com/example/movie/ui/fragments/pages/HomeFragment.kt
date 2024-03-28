package com.example.movie.ui.fragments.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.HomePageViewModel
import com.example.movie.R
import com.example.movie.adapter.MovieAdapter
import com.example.movie.adapter.RecentMovieAdapter
import com.example.movie.databinding.FragmentHomeBinding
import com.example.movie.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? =null
    private val binding get() = _binding!!

    val viewModel by lazy {
        ViewModelProvider(this,defaultViewModelProviderFactory).get(HomePageViewModel::class.java)
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var recentMovieAdapter: RecentMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentHomeBinding.inflate(inflater,container,false)
        val view=binding.root

        initRecyclerAdapters()

        // ViewModel'den veri al
        viewModel.getObserverLiveData(true).observe(viewLifecycleOwner, { movie ->
            movie?.let {
                movieAdapter.setList(it.results)
            }
        })
        // ViewModel'den veri al
        viewModel.getObserverLiveData(false).observe(viewLifecycleOwner, { movie ->
            movie?.let {
                recentMovieAdapter.setList(it.results)
            }
        })

        fetchMovies()

        // Popüler filmleri yükle
        viewModel.loadPopularLiveData(false,apiKey = Constants.APIKEY,"3")

        return view
    }

    fun initRecyclerAdapters(){
        // RecyclerView'ı başlat
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)

        recyclerView2=binding.recyclerView2
        recyclerView2.layoutManager=
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)


        // MovieAdapter oluştur ve RecyclerView'a ata
        movieAdapter = MovieAdapter(true)
        recyclerView.adapter = movieAdapter

        recentMovieAdapter=RecentMovieAdapter()
        recyclerView2.adapter=recentMovieAdapter
    }

    fun fetchMovies(){

        CoroutineScope(Dispatchers.IO).launch {
            val job1: Deferred<Unit> = async {
                viewModel.loadPopularLiveData(true, apiKey = Constants.APIKEY, "6")
            }

            val job2: Deferred<Unit> = async {
                viewModel.loadPopularLiveData(false, apiKey = Constants.APIKEY, "1")
            }

            job1.await()
            job2.await()
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}