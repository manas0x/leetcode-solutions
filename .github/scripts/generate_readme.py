import os

repo_dir = "."

readme_content = """# 🚀 Coding Interview Solutions
A comprehensive collection of my data structures and algorithms solutions, neatly organized by platform and topic tags!

"""

for platform in ["LeetCode", "GeeksForGeeks"]:
    platform_dir = os.path.join(repo_dir, platform)
    if not os.path.exists(platform_dir):
        continue
    
    readme_content += f"## 📁 {platform}\n\n"
    
    items = sorted(os.listdir(platform_dir))
    for item in items:
        item_dir = os.path.join(platform_dir, item)
        if not os.path.isdir(item_dir):
            continue
        
        if platform == "GeeksForGeeks":
            problem = item
            encoded_problem = problem.replace(" ", "%20")
            readme_content += f" - 📄 [{problem}](./{platform}/{encoded_problem})\n"
        else:
            topic = item
            readme_content += f"<details>\n<summary><b>{topic.replace('-', ' ')}</b></summary>\n<br>\n\n"
            problems = sorted(os.listdir(item_dir))
            for problem in problems:
                if os.path.isdir(os.path.join(item_dir, problem)):
                    encoded_topic = topic.replace(" ", "%20")
                    encoded_problem = problem.replace(" ", "%20")
                    readme_content += f" - 📄 [{problem}](./{platform}/{encoded_topic}/{encoded_problem})\n"
            readme_content += "\n</details>\n\n"

with open(os.path.join(repo_dir, "README.md"), "w") as f:
    f.write(readme_content)
