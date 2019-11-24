# RTFL
Read The (Freely Hosted) License

# Stop Your Cargo-Culting Bullshit Having the _LICENSE_ at the top of every single source file.

Why you might ask?  Here are a few reasons:

## It makes you look old
Basically every modern language has accepted a repository cantered view of licensing with a single
top level file (**[repo_root]/LICENSE**) which integrates with build-system, IDE, code-hosting, indexing, and search.

## There is no legal benefit:
A _license_ is not a _copyright_.  A _license_ is a document describing the terms under which a piece of
software **may** be used, whereas a _copyright_ is an **AUTOMATIC** [international right](https://en.wikipedia.org/wiki/Berne_Convention) granted to all
content creators which *forbids* the unlicensed use/duplication by others.

It is the responsibility of the duplicator of copyright work to ensure that their use is permitted by
the copyright holder.

## It kills people:

If every time an reader loads up a file they must first take a second to scroll past
redundant front-matter, and they do this (conservatively) 5 times a day, and only on
work days, by the end of their career thy will have spent an entire day of their life
ignoring this garbage.

This means that for the 
[21 million engineers](https://evansdata.com/reports/viewRelease.php?reportID=9) today,
we are spending over **5.5 human lifetimes EVERY YEAR.** 
These are the collective lives of people like you that we will never get back. 
Which reminds me...

## It is a chore:

Do you know the copyright date on your files? Copyright is protected for 50 years after
the content creators death.  Inclusion of *copyright date and authorship* is the best
way to make sure these rights are protected. Are you excited about updating this in every
single file in your whole repository?  You sure shouldn't be because there is literally a
best practice acronym to describe why this sucks...

## DRY
Unnecessary duplication leads to version drift between copies, poor maintainability,
and [host](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself) of other issues.
Without a mechanism to check for consistency these **will** end up wrong,
this weakens protection, wastes space, and has no...

## Integrity
Without a single source of truth your protections are weaker. 
Which of several competing licenses apply is less clear and overall weakens your protections.

# So what should I do?
This [rtfl.io](http://rtfl.io) is here to help.
