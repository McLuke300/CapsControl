CapsControl
============

Version: 0.1

CraftBukkit Build 1.2.5-RO.3 [Tested]

Info

It is a fully configurable AntiCaps that turns messages from this "SPAMSPAMSPAM" to this "spamspamspam" and is fully configurable.

Allows you to set the percent caps to convert to lowercase.
Allows you to set the minimum word count eg. It wont do anything to words under lets say 5 letters.
Config

NoCaps:
  #When true turns Caps to lowercase#
  ConvertToLowerCase: true

  #Message sent to player on overuse of caps#
  Message: '&6Do not use all caps!' 

CapChecker:
  #The Minimum Character count that is not changed to lowercase#
  MinimumCharacterCount: 7 

  #The percent needed of caps in a message for CapsControl to work#
  Percent: 70 

  #Checks Commands, useful for /me, /broadcast#
  CheckCommands: false
Commands

/nocaps reload - nocaps.reload #Reloads the config from file#

Nocaps Bypass = nocaps.bypass #Allows you to bypass the caps check#

Changelog

- v0.1

•First Release