package com.example.rescuemap

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment

class AgenciesFragment : Fragment() {

    private lateinit var agencyListView: ListView
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_agencies, container, false)

        agencyListView = view.findViewById(R.id.agencyListView)

        val fireButton = view.findViewById<Button>(R.id.filterFire)
        val medicalButton = view.findViewById<Button>(R.id.filterMedical)
        val policeButton = view.findViewById<Button>(R.id.filterPolice)

        // Filter logic
        fireButton.setOnClickListener { displayAgencies("Fire") }
        medicalButton.setOnClickListener { displayAgencies("Medical") }
        policeButton.setOnClickListener { displayAgencies("Police") }

        // Show all by default
        displayAgencies("All")

        return view
    }

    private fun displayAgencies(type: String) {
        val filtered = if (type == "All") {
            RescueData.agencies
        } else {
            RescueData.agencies.filter { it.type.equals(type, ignoreCase = true) }
        }

        val agencyDetails = filtered.map {
            "${it.name}\nType: ${it.type}\nPhone: ${it.phoneNumber}\nEmail: ${it.email}"
        }

        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, agencyDetails)
        agencyListView.adapter = adapter
    }
}
