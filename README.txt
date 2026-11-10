CYBER AI — NATIVE ANDROID DEFAULT ASSISTANT PROJECT

This is an Android Studio/Gradle source project. It packages the current Cyber AI
phone-control HTML interface inside a native Android WebView and adds a real
Android VoiceInteractionService plus RoleManager default-assistant request.

WHAT IS IMPLEMENTED
- Cyber AI app opens as a native Android APK, not a browser tab.
- Android system assistant service and assistant session are declared.
- Settings button calls RoleManager.requestRole(ROLE_ASSISTANT) on Android 10+.
- The assistant session shows a Cyber AI surface and an Open Cyber AI button.
- The WebView exposes window.CyberAndroid methods for default assistant status,
  opening selected Android settings pages, requesting runtime permissions,
  launching installed apps, opening the dialer with a number, opening the SMS
  composer with a draft, flashlight control, vibration and reading contacts after
  permission is granted.
- The existing window.AaronNative bridge is retained for Android speech
  recognition and Android text-to-speech.
- Phone actions are not silently performed: calls open the dialer for the user to
  confirm; SMS opens the messaging composer for the user to review and send.
- Wi-Fi and Bluetooth controls open Android's own settings because modern Android
  restricts apps from silently switching these radios.

IMPORTANT LIMITATIONS
- This is source code, not an APK. It must be built and installed.
- Android 10+ supports the default-assistant role picker. The phone manufacturer
  may restrict or omit assistant-role support. Cyber AI must appear in the chooser.
- The initial system-assistant screen is a lightweight handoff surface. It opens
  the full Cyber AI app; it is not yet a complete always-on conversational
  VoiceInteractionSession with hotword detection.
- A default-assistant role does not grant unrestricted phone control. Android
  permission prompts, role rules, confirmation screens and manufacturer limits
  still apply.
- Direct SMS sending, automatic call placement, silent Wi-Fi/Bluetooth toggles,
  changing protected system settings, notification scheduling and background
  wake-word listening are not implemented. Use Android's system UI for protected
  operations.
- Contact reading is permission-gated. Do not request contacts unless the user
  explicitly asks for them.
- Microphone use requires the user to grant RECORD_AUDIO. Background microphone
  listening is not guaranteed while the app is closed or the screen is locked.

BUILD FROM AN ANDROID PHONE USING GITHUB ACTIONS
1. Download and extract this ZIP.
2. Create a GitHub repository.
3. Upload the CONTENTS of the extracted CyberAI_Android_Assistant_Project folder
   to the repository root. Do not upload the outer folder as an extra nested level.
4. Open the repository's Actions tab.
5. Choose "Build Cyber AI Android APK" and tap Run workflow.
6. Wait for the workflow to finish successfully.
7. Open the workflow run and download the artifact named Cyber-AI-Android-APK.
8. Extract the artifact ZIP and install app-debug.apk. Allow installs from your
   chosen file manager/browser if Android asks.
9. Open Cyber AI, grant only the permissions you want to use.
10. In Cyber AI Settings, tap "Set Cyber AI as phone assistant".
11. In Android's chooser, select Cyber AI. If it does not appear, open Android
    Settings → Apps → Default apps → Digital assistant app and check again.
12. Invoke the assistant using the phone's configured assistant gesture/button.

PROJECT FILES
- app/src/main/assets/index.html: Cyber AI interface
- app/src/main/java/com/cyberai/app/MainActivity.java: WebView + native bridge
- CyberVoiceInteractionService.java: Android system assistant service
- CyberVoiceInteractionSessionService.java: creates assistant session
- CyberVoiceInteractionSession.java: assistant handoff UI
- app/src/main/res/xml/voice_interaction_service.xml: assistant metadata

Package: com.cyberai.app
App label: Cyber AI
Minimum Android: 8.0 (API 26); assistant role picker: Android 10 (API 29)+
