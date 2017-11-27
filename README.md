Parcial 2 – Jorge David Runza Gualdron
Repositorio con la evidencia: https://github.com/Jorgerunza/Parcial2-PruebasAutomaticas 
Aplicación Mutada K9-Mail : https://github.com/k9mail/k-9 

Mutante 1 : MissingPermissionManifest

Mutant 73: 
C:\Users\Jorge\Desktop\Parcial\K9-mut\com.fsck.k9-mutant73\\AndroidManifest.xml; 

MissingPermissionManifest in line 26

Se elimina permiso android.permission.WAKE_LOCK.

 

Mutante 2 : ActivityNotDefined

Mutant 30: 
C:\Users\Jorge\Desktop\Parcial\K9-mut\com.fsck.k9-mutant30\\AndroidManifest.xml; 

ActivityNotDefined in line 75

Se elimina actividad com.fsck.k9.activity.Accounts

 

Mutante 3 : InvalidActivityPATH

Mutant 1: 
C:\Users\Jorge\Desktop\Parcial\K9-mut\com.fsck.k9-mutant1\\AndroidManifest.xml; 
InvalidActivityPATH in line 75

se modifica la linea  de android:name=".activity.Accounts" a android:name=".activity.Aoccunts".

 

Mutante 4 : WrongStringResource

Mutant 182: 
C:\Users\Jorge\Desktop\Parcial\K9-mut\com.fsck.k9-mutant182\\res\values\strings.xml; 

WrongStringResource in line 181

Se modifica   <string name="about_action">Acerca de</string>  a  <string name="about_action">f521bdb8cb7f4fcf81be40239d164c16</string>

 

Mutante 5 : WrongMainActivity

Mutant 1054: 
C:\Users\Jorge\Desktop\Parcial\K9-mut\com.fsck.k9-mutant1054\\AndroidManifest.xml; 

WrongMainActivity in line 212

Se modifica android:name=".activity.MessageList" por android:name=".activity.setup.AccountSetupAccountType"

 

Mutante 6 : InvalidIndexQueryParameter

Mutant 1026: 
tmp/mutants/com.fsck.k9-mutant1026//java/com/fsck/k9/mailstore/LocalFolder.java; 

InvalidIndexQueryParameter in line 161

Se modifica la linea cursor = db.rawQuery(baseQuery + "where folders.name = ?", new String[] { name });
eliminando el parametro de entrada:
cursor = db.rawQuery(baseQuery + "where folders.name = ?", new String[]{ });


 

Mutante 7 : ViewComponentNotVisible

Mutant 1085: 
tmp/mutants/com.fsck.k9-mutant1085//java/com/fsck/k9/activity/FolderList.java; 
ViewComponentNotVisible in line 960


Se modifica la linea 961 agregando la siguiente propiedad para ocultar el elemento  
holder.folderName.setVisibility(android.view.View.INVISIBLE);


 
Mutante 8 : NullIntent

Mutant 1190: 
tmp/mutants/com.fsck.k9-mutant1190//java/com/fsck/k9/activity/setup/AccountSetupNames.java; 
NullIntent in line 32

Se modifica la linea 32 haciendo nula la variable Intent i = null;

 

Mutante 9 : InvalidSQLQuery

Mutant 1321: 
tmp/mutants/com.fsck.k9-mutant1321//java/com/fsck/k9/mailstore/LocalFolder.java; 

InvalidSQLQuery in line 161

Se modifica el cursor de base de datos a:
  cursor = db.rawQuery(baseQuery + "85806aff354341c98e481d416f97870c", new String[] { name });

 


Mutant 1386: 
tmp/mutants/com.fsck.k9-mutant1386//java/com/fsck/k9/activity/Accounts.java; 
Mutante 10 : NullValueIntentPutExtra

NullValueIntentPutExtra in line 349

Se modifica el parametro de entrada de la funcion 

intent.putExtra(EXTRA_STARTUP, false); a
intent.putExtra(EXTRA_STARTUP,new android.os.Parcelable[0]);

