package com.example.lab6.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab6.R
import com.example.lab6.adapter.NewsRecyclerViewAdapter
import com.example.lab6.databinding.FragmentNewsBinding
import com.example.lab6.databinding.NewsViewBinding
import com.example.lab6.dialog.AddNewSportDialogFragment
import com.example.lab6.dialog.AddNewsDialogFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class NewsFragment : Fragment() {

 lateinit var binding: FragmentNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

      binding = FragmentNewsBinding.inflate(inflater, container, false)

     binding.newsRecyclerView.adapter = NewsRecyclerViewAdapter( requireContext(),  news)

     binding.newsRecyclerView.layoutManager = LinearLayoutManager(this.context, )


     binding.newsFab.setOnClickListener{

      AddNewsDialogFragment( object : AddNewsDialogFragment.AddNewsDialogCallback {
       override fun onNewsAdded(item: NewsArticle) {


        Log.d("TAG", "onNewsAdded: ${item.description}")
        Log.d("TAG", "onNewsAdded: ${item.urlToImage}")
        Log.d("TAG", "onNewsAdded: ${item.title}")
        news.add(0, item)
        binding.newsRecyclerView.adapter?.notifyItemInserted(0)



       }
      }).show(parentFragmentManager, "ADD_NEW_SPORT_DIALOG")

     }

        return binding.root
    }

    companion object {

        data class NewsArticle(
            val title: CharSequence,
            val description: CharSequence,
            val urlToImage: CharSequence
        )


       val news =  mutableListOf(
        NewsArticle  ("Ford Is Enticing Tesla Owners With Special F-150 Lightning EV Discount",
        "Ford isn’t going after Tesla — just its customers. The Big Three legacy car titan has unveiled a special discount for Tesla owners who purchase its F-150 Lightning EV pickup, just one day after Ford dropped the Lightning’s price by up to $5,500 to boost flagg…",
        "https://c.biztoc.com/274/og.png")
        ,

        NewsArticle  ("Is EU competition working? One company shows a 250 percent increase. Hashtag Trending for Friday April 12, 2024",
        "US Internet providers must now display clear pricing and product information. HP Ink controversy continues to stain the company’s reputation with consumers. Is the EU’s competition legislation working? Early numbers seem to show it might be. And there’s a 10 …",
        "https://i.itworldcanada.com/wp-content/uploads/2023/04/Hashtag-TRending-2.png")
        ,


        NewsArticle  ("Rivian, Lucid at New Lows as Ford Price Cut Fans EV Concerns",
        "Shares of electric vehicle startups Rivian Automotive Inc. and Lucid Group Inc. closed at all-time lows Thursday after Ford Motor Co. slashed prices on its electric pickup truck. • None US Sees Imminent Missile Strike on Israel by Iran, Proxies • None US Slam…",
        "https://c.biztoc.com/p/df2c697fec9f9a25/og.webp")
        ,

        NewsArticle  ("Test Shows the Model X Has Better Range Than the Cybertruck When Pulling the Same Trailer",
        "Weighed Down Despite being designed to pull trailers that weigh many thousands of pounds, Tesla's Cybertruck is seemingly not great at the whole towing thing. Geneva Long, founder and CEO of all-electric RV maker Bowlus, found that a Model X figuratively ran …",
        "https://wp-assets.futurism.com/2024/04/test-model-x-better-range-cybertruck-pulling-trailer.jpg")
        ,

        NewsArticle  ("Ford targets Tesla owners with $1,500 EV 'conquest' rebates",
        "is targeting one automaker in particular when it comes to boosting EV sales — Tesla (TSLA). As first noted by CarsDirect.com (via Ford Authority), Ford sent out an incentive bulletin to its dealers offering a $1,500 rebate specifically for Tesla owners who pu…",
        "https://c.biztoc.com/p/132cb3d3488dc28b/og.webp")
        ,

        NewsArticle  ("What are electric vehicle stock prices? Rivian, Lucid face record lows",
        "Shares of electric vehicle startups Rivian Automotive Inc. and Lucid Group Inc. are staring down all-time lows Thursday after Ford Motor Co. slashed prices on its electric pickup truck. The industrywide price war on electric autos is a major concern for inves…",
        "https://c.biztoc.com/p/dff01fb65d712367/og.webp")
        ,



        NewsArticle  ("You Just Need an EV Charger in One of These 3 Places",
        "If you don’t have an electric car, there are two questions you are almost certain to have about an electric car — how long does it take to charge, and how far does the car take you on a full charge? In reality, those issues, especially the former, matter very…",
        "https://cleantechnica.com/wp-content/uploads/2023/12/Tesla-Model-3-Home-Charging-110V-Tennis-Balls-CleanTechnica-e1617245576144.jpeg")
        ,

        NewsArticle  ("The Fallout 4 next-gen update announced in 2022 will finally be out later this month",
        "Almost in time for the Fallout TV series on Amazon.",
        "https://cdn.mos.cms.futurecdn.net/qpRzGc9zWMLVXJwEq7v8R-1200-80.jpg")
        ,

        NewsArticle  ("3 EV Stocks to Avoid Like a Dead Battery After Xiaomi’s SU7 Triumph",
        "Here are three EV stocks to avoid in Xiaomi's wake Xiaomi (OTCMKTS: ), known for its smartphones, is making a bold entry into the electric vehicle (EV) market. The company announced it will launch its first EV at competitive prices, which put several names in…",
        "https://c.biztoc.com/p/858a566ebe240256/s.webp")
        ,

        NewsArticle  ("What to know about Elon Musk's 'free speech' feud with a Brazilian judge",
        "Elon Musk is clashing with a bald, athletically built Supreme Court justice in Brazil over free speech, far-right accounts and misinformation on X",
        "https://i.abcnewsfe.com/a/9accf2d9-8038-430e-9bb2-305c40bac1a4/wirestory_bef06c0dbbb8ed87495b1afbb0edf211_16x9.jpg?w=1600")
        ,

        NewsArticle  ("What to know about Elon Musk's 'free speech' feud with a Brazilian judge",
        "Headline-grabbbing billionaire Elon Musk is clashing with a Supreme Court justice in Brazil over free speech, far-right accounts and misinformation on X, the social media platform Musk bought when it was Twitter. Since his takeover, Musk has upended many of T…",
        "https://c.biztoc.com/p/760e6fc28738e347/s.webp")
        ,

        NewsArticle  ("What to know about Elon Musk's 'free speech' feud with a Brazilian judge",
        "Headline-grabbbing billionaire Elon Musk is clashing with a Supreme Court justice in Brazil over free speech, far-right accounts and misinformation on X, the social media platform Musk bought when it was Twitter.",
        "https://www.startribune.com/static/img/branding/logos/strib-social-card.png?d=1712855680")
        ,

        NewsArticle  ("What to know about Elon Musk’s ‘free speech’ feud with a Brazilian judge",
        "Elon Musk is clashing with a bald, athletically built Supreme Court justice in Brazil over free speech, far-right accounts and misinformation on X. The headline-grabbbing billionaire bought the social media platform when it was Twitter. He has upended many of…",
        "https://www.bostonherald.com/wp-content/uploads/2024/04/Brazil_Musk_Investigation_45984_f3ac0f.jpg?w=1024&h=683")
        ,

        NewsArticle  ("Xiaomi Electrifies the Road: First EV, the SU7, Races Out of the Gate with Over 100,000 Orders and Begins Deliveries",
        "Beijing, China – April 11, 2024 – Buckle up, because Xiaomi is shifting gears and leaving the competition in the dust. The Chinese tech titan has stormed into the electric vehicle (EV) market with its debut car, the SU7, and it's already a runaway success. Ju…",
        "https://energycentral.com/sites/default/files/styles/og_meta/public/ece/node_main/2024/4/xiaomi.webp?itok=OanCeSh3")
        ,

        NewsArticle  ("Mercedes-Benz India steals a march over rivals in EV race",
        "Mercedes-Benz has also firmed up plans to launch three new battery electric vehicles this calendar year to further consolidate its position in the EV space. This will form part of the dozen new models the company plans to introduce during the year.",
        "https://img.etimg.com/thumb/msid-109227024,width-1200,height-630,imgsize-54396,overlay-economictimes/photo.jpg")
        ,



        NewsArticle  ("The 2025 Toyota 4Runner Has Tons of Buttons Inside. That’s on Purpose",
        "Rather than slapping an iPad on the dash and calling it a day, the 4Runner's interior designers considered how to make its interface useful and practical.",
        "https://s.yimg.com/ny/api/res/1.2/lo8IvKYXzRZHV73pqe7rSw--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD02NzU-/https://media.zenfs.com/en/the_drive_634/e9421408159475b4a63fa15837e9558b")
        ,

        NewsArticle  ("Ford targets Tesla owners with $1,500 EV 'conquest' rebates",
        "is targeting one automaker in particular when it comes to boosting EV sales — Tesla (TSLA). As first noted by CarsDirect.com (via Ford Authority), Ford sent out an incentive bulletin to its dealers offering a $1,500 rebate specifically for Tesla owners who pu…",
        "https://c.biztoc.com/p/55bd15f813bfaea7/s.webp")
        ,

        NewsArticle  ("Strong Q1 demand for IPOs bodes well for 2024, experts say: ‘I’m way more optimistic than I’ve been the last two years’",
        "The market is heating up at the top. But will it trickle down?",
        "https://fortune.com/img-assets/wp-content/uploads/2024/04/NYSE-Trader-GettyImages-e1712858504417.jpg?resize=1200,600")

        )


    }
}