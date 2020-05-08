package hlabu.khrihfa.myapplication.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.*
import hlabu.khrihfa.myapplication.Adapter.replaceFragmenty

import hlabu.khrihfa.myapplication.Fragment.BlankFragment
import hlabu.khrihfa.myapplication.Fragment.InfromationTechnologyDepartmentFragment
import hlabu.khrihfa.myapplication.Fragment.MainFragment
import hlabu.khrihfa.myapplication.Fragment.TechnologyUniversityMandalayFragment
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.fragment_blank.view.*
import android.webkit.WebViewClient
import hlabu.khrihfa.myapplication.R


class NavigationDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener
{
lateinit var credit_stu_list:List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        //floating action button
      /*  val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/

        val tx = fragmentManager.beginTransaction()
        tx.replace(R.id.container, MainFragment())
        tx.commit()


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)




    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation_drawer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
         when (item.itemId) {
             R.id.action_settings -> {
                 val builder = AlertDialog.Builder(this@NavigationDrawerActivity)
                 builder.setTitle("Data Credits to those Students")
                 val mDiaView = layoutInflater.inflate(R.layout.credit_dialog_layout, null)

                // val  stu_Listview:ListView = mDiaView.findViewById(R.id.credit_stu_listView)
                 val  stu_Listview:ListView = mDiaView.findViewById(R.id.credit_dialog_listview)
                 credit_stu_list = listOf(
                     "ဟိန္းထက္စိုး",
                     "သီရိေမာင္၀င္း",
                     "ဥာဏ္လင္းထက္",
                     "မင္းသြင္ခ",
                     "စုျပည့္ျပည့္ေအာင္",
                     "Anna Yaung",
                     "သင္းသီရိေဇာ္",
                     "ေအာင္ခိုင္မိုးဦး",
                     "ေအာင္မ်ိဳးေက်ာ္",
                     "ေအးျမစႏၵာ")




                 val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,credit_stu_list)
                 stu_Listview.adapter=adapter



                 builder.setView(mDiaView)
                 val dialog: AlertDialog = builder.create()

                 dialog.show()
              //   Toast.makeText(this, "hello gellery", Toast.LENGTH_LONG).show()
                 return true
             }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
                replaceFragmenty(
                    fragment = MainFragment(),
                    allowStateLoss = true,
                    containerViewId = R.id.container
                )
                setTitle("Infromation_Technology")


                }
            R.id.nav_gallery -> {

                replaceFragmenty(
                  fragment = TechnologyUniversityMandalayFragment(),
                    allowStateLoss = true,
                    containerViewId = R.id.container
                )
                setTitle("TUM")
                //Toast.makeText(this,"hello gellery",Toast.LENGTH_LONG).show()

            }
            R.id.nav_slideshow -> {
                replaceFragmenty(
                    fragment = InfromationTechnologyDepartmentFragment(),
                    allowStateLoss = true,
                    containerViewId = R.id.container
                )
                setTitle("IT Department")
            }

            R.id.nav_share -> {
              replaceFragmenty(
                    fragment = BlankFragment(),
                    allowStateLoss = true,
                    containerViewId = R.id.container
                )
                setTitle("Contact us")


               /* var gourl= (this,Uri.parse("https://www.facebook.com/"))
                    //Intent(,Uri.parse("https://www.facebook.com/"))
                startActivity(gourl)*/
            }

        }
        val drawerLayout: DrawerLayout = findViewById( hlabu.khrihfa.myapplication.R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


}
