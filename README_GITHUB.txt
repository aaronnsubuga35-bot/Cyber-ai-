CYBER AI — GITHUB-READY ANDROID PROJECT

This ZIP contains the native Android WebView app, the latest Cyber AI HTML interface, the Android app-launcher bridge, and a GitHub Actions workflow to build a debug APK.

IMPORTANT: This is source code, not an APK. A successful GitHub Actions run is required to create the APK. Android controls remain subject to Android permissions and device restrictions.

UPLOAD TO GITHUB (PHONE)
1. Extract this ZIP on your phone.
2. Open your GitHub repository.
3. Upload ALL CONTENTS of the extracted folder directly into the repository root. Do not upload only the HTML file, and do not create an extra nested project folder.
4. Confirm that the repository root shows: app/, .github/, build.gradle, settings.gradle, and gradle.properties.
5. Open Actions. Select “Build Cyber AI Android APK” and tap Run workflow.
6. Wait for the run to finish. If it succeeds, open the run and download “Cyber-AI-Android-APK” under Artifacts.
7. Extract the artifact and install app-debug.apk.

APP LAUNCHER
The native Android bridge searches launchable installed apps by their displayed name and opens the best match. Example: “Open WhatsApp”. The app must be installed and launchable. Android package visibility rules and manufacturer restrictions may affect results.

LIMITATIONS
- HTML opened in a normal browser cannot launch arbitrary installed Android apps. This feature needs the native APK bridge.
- Default assistant selection is available only on supported Android versions/devices and requires the user to choose Cyber AI in Android's system prompt.
- This assistant is not a guaranteed always-on hotword service.
- Calls and SMS open their system composer/dialer for the user to confirm. Protected settings and radios remain controlled by Android.
- This ZIP has not been built or device-tested in this environment.

PROJECT ROOT FILES
- app/
- .github/workflows/build-apk.yml
- build.gradle
- settings.gradle
- gradle.properties
