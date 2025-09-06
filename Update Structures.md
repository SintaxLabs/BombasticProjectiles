# Update Structure
Maintaining API compatibility as far as supported is my primary goal.

Once support is ended, legacy updates are not prioritized or gauranteed.

| MC Version    | API  | Support |
| :---------:   | :-:  | :-----: |
| 1.12          | 1.12 |  ⛔ |
| 1.16 - 1.21.x | 1.16 |  ✅ |

## How?
Once a new API is required, the previous will have support dropped.
> Ex: 1.16 API is compatible up to 1.21. If 1.22 requires 1.22 API then all 1.16 support is dropped. 

## Why?
Updating by API compatibility instead of each new API keeps a unified codebase.

This dramatically shortens time to bugfix multiple MC versions and requires less resources.
