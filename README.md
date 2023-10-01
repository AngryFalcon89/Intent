# Intent
                                     ![preview](https://github.com/AngryFalcon89/Intent/assets/91687355/2633cd37-f644-4825-82c7-3dc79d6a06cb)

Intents are a fundamental component in Android app development, facilitating communication between different parts of an app or between different apps.<br>
There are two primary types of intents:
-Implicit Intent
-Explicit Intent

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
Create a Serializable class that represents the user data you want to transfer. Make sure it implements the Serializable interface:

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
