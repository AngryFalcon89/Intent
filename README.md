# Intent

Intents are a fundamental component in Android app development, facilitating communication between different parts of an app or between different apps.<br>
There are two primary types of intents: Implicit and Explicit.

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
