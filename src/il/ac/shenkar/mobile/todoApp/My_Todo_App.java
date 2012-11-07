package il.ac.shenkar.mobile.todoApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import com.example.my_todo_app.R;
import android.view.View;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class My_Todo_App extends Activity 
{

	public final static String EXTRA_MESSAGE = "com.example.my_todo_app.MESSAGE";
    @SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__todo__app);
        ArrayList<Task> taskListItems = GetAllTasks();
        Collections.sort(taskListItems);
        final ListView tasksListView = (ListView) findViewById(R.id.listV_main);
        //set the listView adapter
        tasksListView.setAdapter(new TaskListBaseAdapter(this, taskListItems));
        //item click listener
        tasksListView.setOnItemClickListener(new OnItemClickListener() 
		{
        	public void onItemClick(AdapterView<?> a, View v, int position, long id) 
			{ 
        		Object o = tasksListView.getItemAtPosition(position);
            	Task obj_itemDetails = (Task)o;
        		Toast.makeText(My_Todo_App.this, "You have chosen : " + " " + obj_itemDetails.getTaskName(), Toast.LENGTH_LONG).show();
        	}  
        });
    }
    
    public void addTask(View view) 		//open "add task" activity in response to button
    {
    	Intent intent = new Intent(this, NewTaskActivity.class);
    	startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.activity_my__todo__app, menu);
        return true;
    }
    
    //sample task generator - for task list check only
    
    private ArrayList<Task> GetAllTasks()
	{
    	ArrayList<Task> results = new ArrayList<Task>();
    	//Instantiate several tasks & insret them into the task list 
    	Task taskDetails = new Task("Do homework", "Mobile andriod list view task",
    			new GregorianCalendar(2012,11,07,12,30), new GregorianCalendar(2012,11,10,12,30),true , Importancy.MEDIUM, true );
    	results.add(taskDetails);
    	taskDetails = new Task("wash my car", "",
    			new GregorianCalendar(2012,11,07,12,30), new GregorianCalendar(2012,11,10,12,30),true , Importancy.NONE, false );
    	results.add(taskDetails);
    	taskDetails = new Task("fix the computer", "install a new operating system",
    			new GregorianCalendar(2012,11,07,12,30), new GregorianCalendar(2012,11,10,12,30),true , Importancy.MEDIUM, false );
    	results.add(taskDetails);
    	taskDetails = new Task("Update mobile os version", "Update my iphone operating system version to ios6.1",
    			new GregorianCalendar(2012,11,07,12,30), new GregorianCalendar(2012,11,10,12,30),true , Importancy.MEDIUM, true );
    	results.add(taskDetails);
    	taskDetails = new Task("buy new sunglasses", "",
    			new GregorianCalendar(2012,11,07,12,30), new GregorianCalendar(2012,11,10,12,30),true , Importancy.MEDIUM, false );
    	results.add(taskDetails);
    	taskDetails = new Task("call mom", "",
    			new GregorianCalendar(2012,11,07,12,30), new GregorianCalendar(2012,11,10,12,30),true , Importancy.MEDIUM, false );
    	results.add(taskDetails);
    	taskDetails = new Task("call dad", "",
    			new GregorianCalendar(2012,11,07,12,30), new GregorianCalendar(2012,11,10,12,30),true , Importancy.MEDIUM, true );
    	results.add(taskDetails);
    	taskDetails = new Task("buy present to dor", "",
    			new GregorianCalendar(2012,11,07,12,30), new GregorianCalendar(2012,11,10,12,30),true , Importancy.HIGH, false );
    	results.add(taskDetails);
    	taskDetails = new Task("tell yifat that i love her", "very important :)",
    			new GregorianCalendar(2012,11,07,12,30), new GregorianCalendar(2012,11,10,12,30),true , Importancy.HIGH, true );
    	results.add(taskDetails);
    	taskDetails = new Task("update this task list", "",
    			new GregorianCalendar(2012,11,07,12,30), new GregorianCalendar(2012,11,10,12,30),true , Importancy.LOW, false );
    	results.add(taskDetails);
    	//return task list to caller	
    	return results;
    }
}
