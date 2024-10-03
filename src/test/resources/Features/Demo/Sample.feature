@demo
Feature: Quick Demos

@test7 @ui @sidebysidepoc
	Scenario: Demo framework changes for headless side by side website
	Given web site is launched successfully and user "does" accept the cookies
	And customer accesses the website as "login" user

	@test8
	Scenario Outline: Visual testL0 category Node page <store>
	Given user navigate to "<store>" store homepage and "does" accept the cookies
	When customer accesses the website as "guest" user
	And create folder structure for base & resultant images
	And I navigate to "<categoryPage>" page
	And I wait for "5" seconds
	And visually compare "viewport" with the baseline "<image>"
	And visually compare "full" page with the baseline "<image>"
	And skip if baseline image captured
	Examples:
		| store | categoryPage                 | image              |
		| uk    | c/audio-visual               | audioVisual        |
		| uk    | c/automation-process-control | autoprocesscontrol |

