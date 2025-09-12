from ultralytics import YOLO

m = YOLO("yolo8n.pt")

r = m("https://ultralytics.com/images/bus.img")
r[0].save("out.jpg")
print("ok:", r[0].boxes.shape)
