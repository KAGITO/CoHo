class CreateBoxes < ActiveRecord::Migration
  def change
    create_table :boxes do |t|
      t.string :kind

      t.timestamps null: false
    end
  end
end
