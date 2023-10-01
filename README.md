# Intent

![file](https://github.com/AngryFalcon89/Intent/assets/91687355/1bdbb13c-66c0-4cfb-a859-09190a10f51e)


Intents are a fundamental component in Android app development, facilitating communication between different parts of an app or between different apps.<br>
There are two primary types of intents:
- Implicit Intent
- Explicit Intent

---

## Implicit Intents

Implicit intents are used when you want the **Android system** to determine which component should handle the request based on the action specified in the intent.<br>

Here's how to create an implicit intent in Kotlin:

### Step 1: Declare Intent Action

In your Kotlin code, declare the action you want to perform. For example, to open a web page:

```kotlin
val intent = Intent()
```
### Step 2: Create Intent and set the URL
Create an intent with the specified action (and set the URL for this specific case)

```kotlin
intent.action = Intent.ACTION_VIEW
intent.setData(Uri.parse("https://www.google.com/"))
```

### Step 3: Start Activity
To start an activity that can handle the action, call startActivity() with your intent:

```kotlin
startActivity(intent)
```
---

## Explicit Intents

Explicit intents are used when you want to specify the exact component (e.g., an Activity) that should handle the intent.<br>

Here's how to create an explicit intent in Kotlin:

### Step 1: Create a New Activity
Create a new activity in your Android project if you haven't already. You can do this by right-clicking on your project's package, selecting "New," and then "Activity" or "Empty Activity."

### Step 2: Create an Intent Object
Inside the setOnClickListener block, create an Intent object. You need to specify both the current activity (this@MainActivity) and the target activity (OtherActivity::class.java).

```kotlin
val intent = Intent(this@MainActivity, OtherActivity::class.java)
```

### Step 3: Create a Serializable Class
Create a Serializable class that represents the user data you want to transfer. Make sure it implements the Serializable interface because intents cannot pass Objects of normal class unless it is Serialisable or parcelable:

```kotlin
import java.io.Serializable

class UserData : Serializable {
    lateinit var name: String
    var age: Byte = -1
    lateinit var phone: String
    lateinit var email: String
}
```

### Step 4: Create Data Object
Create an instance of the UserData class and populate it with the user's input data. Replace UserData with the actual class you've defined for user data.

```kotlin
val userData = UserData()
userData.name = binding.name.text.toString()
userData.age = binding.age.text.toString().toByte()
userData.phone = binding.phone.text.toString()
userData.email = binding.email.text.toString()
```

### Step 5: Put Data into Intent
Use putExtra to put the user data into the intent with a unique key (e.g., "USER_DATA"). This key will be used to retrieve the data in the receiving activity.

```kotlin
intent.putExtra("USER_DATA", userData)
```
### Step 6: Start the Activity with Intent
Finally, use startActivity(intent) to initiate the explicit intent and pass the user data to the OtherActivity.

```kotlin
startActivity(intent)
```

### Step 6: Start the Activity with Intent
Finally, use startActivity(intent) to initiate the explicit intent and pass the user data to the OtherActivity.

```kotlin
startActivity(intent)
```
### Step 7: Destructure and Display Data
In the OtherActivity, retrieve the user data from the intent and destructure it to display the values:

```kotlin
var userData = intent.getSerializableExtra("USER_DATA") as UserData

binding.name.text = userData.name
binding.age.text = userData.age.toString()
binding.phone.text = userData.phone
binding.email.text = userData.email
```

### NOTE 
The following functions were deprecated in Android 13:
- Intent.getParcelableExtra()
- Intent.getSerializableExtra()
- Bundle.getParcelable()
- Bundle.getParcelableArrayList()
- Bundle.getSerializable()
<br> hence we use this code 
```kotlin
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
   model = intent.getSerializableExtra("USER_DATA",OtherActivity::class.java)
} else {
   model = intent.getSerializableExtra("USER_DATA") as UserData?
}
```
