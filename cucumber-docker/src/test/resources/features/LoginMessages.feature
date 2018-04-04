Feature: Login Messages


  Scenario Outline: Login Messages
    When I login with username "<username>" and password "<password>"
    Then I see the message "<message>"

    Examples:
    | ID  | username | password             | message                         |
    | 001 | tomsmith | SuperSecretPassword! | You logged into a secure area!  |
    | 002 | timsmith | SuperSecretPassword! | Your username is invalid!       |
    | 003 | tomsmith | wrong                | Your password is invalid!       |
    | 004 | tomsmith | SuperSecretPassword! | You logged into a secure area!  |
    | 005 | timsmith | SuperSecretPassword! | Your username is invalid!       |
    | 006 | tomsmith | wrong                | Your password is invalid!       |
    | 007 | tomsmith | SuperSecretPassword! | You logged into a secure area!  |
    | 008 | timsmith | SuperSecretPassword! | Your username is invalid!       |
    | 009 | tomsmith | wrong                | Your password is invalid!       |
    | 010 | tomsmith | SuperSecretPassword! | You logged into a secure area!  |
		| 011 | timsmith | SuperSecretPassword! | Your username is invalid!       |
    | 012 | tomsmith | wrong                | Your password is invalid!       |
    | 013 | tomsmith | SuperSecretPassword! | You logged into a secure area!  |
    | 014 | timsmith | SuperSecretPassword! | Your username is invalid!       |
    | 015 | tomsmith | wrong                | Your password is invalid!       |
    | 016 | tomsmith | SuperSecretPassword! | You logged into a secure area!  |
    | 017 | timsmith | SuperSecretPassword! | Your username is invalid!       |
    | 018 | tomsmith | wrong                | Your password is invalid!       |
    | 019 | tomsmith | SuperSecretPassword! | You logged into a secure area!  |
    | 020 | timsmith | SuperSecretPassword! | Your username is invalid!       |
    | 021 | tomsmith | wrong                | Your password is invalid!       |
    | 022 | tomsmith | SuperSecretPassword! | You logged into a secure area!  |
    | 023 | timsmith | SuperSecretPassword! | Your username is invalid!       |
    | 024 | tomsmith | wrong                | Your password is invalid!       |
    | 025 | tomsmith | SuperSecretPassword! | You logged into a secure area!  |
    | 026 | timsmith | SuperSecretPassword! | Your username is invalid!       |
    | 027 | tomsmith | wrong                | Your password is invalid!       |
    | 028 | tomsmith | SuperSecretPassword! | You logged into a secure area!  |
    | 029 | timsmith | SuperSecretPassword! | Your username is invalid!       |
    | 030 | tomsmith | wrong                | Your password is invalid!       |

