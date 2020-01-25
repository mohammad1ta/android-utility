# android-utility
Useful utility classes for android.

## Animation Helper
With this helper, you can assign any type of animation to your element ( such as each listview, gridview and etc. )

### How to use?

**Note:** In the following example codes, first parameter is speed and second is offset ( delay time ).

#### Scale
```java
gridView.setLayoutAnimation( Animation.Scale( 300, 200 ) );
```

#### Fade In
```java
gridView.setLayoutAnimation( Animation.FadeIn( 800, 0 ) );
```

#### Fade Out
```java
gridView.setLayoutAnimation( Animation.FadeOut( 800, 0 ) );
```

#### Slide Up
```java
listView.setLayoutAnimation( Animation.SlideUp( 250, 0 ) );
```

#### Slide Down
```java
listView.setLayoutAnimation( Animation.SlideDown( 250, 0 ) );
```

#### Push Right
```java
listView.setLayoutAnimation( Animation.PushRight( 250, 0 ) );
```

#### Push Left
```java
listView.setLayoutAnimation( Animation.PushLeft( 250, 0 ) );
```

#### Bounce image from up to down
```java
Animation.BounceImage( imageView, 1600 );
```

## Local Storage Helper
With this helper, you can put or get data on in-app local storage.

#### Example
```java
LocalStorage Local = new LocalStorage( this );

// For putting data in storage
Local.putString( "user-email", "example@gmail.com" );
Local.putInt( "userid", 5 );
Local.putBoolean( "is-login", true );

// For getting data of storage
Local.getString( "user-email" );
Local.getInt( "userid" );
Local.getBoolean( "is-login" );
```
