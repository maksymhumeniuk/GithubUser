Github browser with Android Architecture Components
===========================================================

This is a sample app that uses Android Architecture Components with Hilt.

Introduction
-------------

### Functionality
The app is composed of 2 screens.
#### UserScreenFragment
Accept	a	github	user's	id	as	input	and	display	the	specified	user's	avatar	and	name.	
For	each	public	repository	owned	by	the	user,	the	name	and	description	are	shown	in	a	scrollable	list
#### DetailScreenFragment
When	a	repository	is	selected,	user go	to  a	detail	screen	which	display	the	details	regarding	that	
specific repo.



### Libraries
* [Android Support Library][support-lib]
* [Android Architecture Components][arch]
* [Android Data Binding][data-binding]
* [Hilt][hilt] for dependency injection
* [Retrofit][retrofit] for REST api communication
* [Glide][glide] for image loading